package kz.iitu.review.service.impl;

import kz.iitu.review.model.Review;
import kz.iitu.review.repository.ReviewRepository;
import kz.iitu.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review getReview(Long customerId, Long productId) {
        return reviewRepository.findByCustomerIdAndProductId(customerId, productId);
    }

    @Override
    public List<Review> getProductReview(Long productId) {
        return reviewRepository.findByProductId(productId);
    }


    @Override
    public void createReview(Long customerId, Long productId, String message) {
        Review review = new Review();
        review.setCustomerId(customerId);
        review.setProductId(productId);
        review.setMessage(message);
        reviewRepository.saveAndFlush(review);
    }

    @Override
    public void deleteReview(Long customerId, Long productId) {
        Review review = getReview(customerId, productId);
        reviewRepository.deleteById(review.getId());
    }

    @Override
    public void updateReview(Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(review.getId());
        if(optionalReview.isPresent()){
            Review review1 = optionalReview.get();
            review1.setId(review.getId());
            review1.setProductId(review.getProductId());
            review1.setCustomerId(review.getCustomerId());
            review1.setMessage(review.getMessage());
            reviewRepository.saveAndFlush(review1);
        }
    }

}
