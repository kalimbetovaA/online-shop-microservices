package kz.iitu.review.service;

import kz.iitu.review.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    Review getReview(Long customerId, Long productId);
    List<Review> getProductReview(Long productId);
    void createReview(Long customerId, Long productId, String message);
    void updateReview(Review review);
    void deleteReview(Long customerId, Long productId);
}
