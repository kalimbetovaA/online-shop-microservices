package kz.iitu.review.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.review.model.Review;
import kz.iitu.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @ApiOperation(value = "Method to Create a new Review for specific Customer and Product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("")
    public ResponseEntity<?> createReview(@RequestParam Long customerId, @RequestParam Long productId, @RequestParam String message){
        reviewService.createReview(customerId, productId, message);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "To get Review of specific Customer and Product by its Ids", response = Review.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Cart object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("")
    public ResponseEntity<?> getReview(@RequestParam Long customerId, @RequestParam Long productId){
        Review review = reviewService.getReview(customerId, productId);
        return ResponseEntity.ok(review);
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> getProductReview(@PathVariable Long productId){
        List<Review> reviews = reviewService.getProductReview(productId);
        return ResponseEntity.ok(reviews);
    }


    @ApiOperation(value = "Method to Delete Review")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("")
    public ResponseEntity<?> deleteReview(@RequestParam Long customerId, @RequestParam Long productId){
        reviewService.deleteReview(customerId, productId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "Method to Update Review")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("")
    public ResponseEntity<?> updateReview(@RequestBody Review review){
        reviewService.updateReview(review);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
