package com.app.service;

import com.app.pojo.Feedback;
import com.app.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Optional<Feedback> updateFeedback(Long id, Feedback feedback) {
        if (!feedbackRepository.existsById(id)) {
            return Optional.empty();
        }
        feedback.setId(id); // Ensure the ID matches the path variable ID
        return Optional.of(feedbackRepository.save(feedback));
    }

    public boolean deleteFeedback(Long id) {
        if (!feedbackRepository.existsById(id)) {
            return false;
        }
        feedbackRepository.deleteById(id);
        return true;
    }

}
