package service;

import dto.FeedbackAdmin;
import entity.Feedback;
import repository.FeedbackRepository;

import java.util.List;

public class FeedbackService {
    public static void addNewFeedback(Feedback feedback){
        FeedbackRepository.addNewFeedback(feedback);
    }

    public static List<FeedbackAdmin> listAllFeedback(){
        return FeedbackRepository.listAllFeedback();
    }

    public static void deleteFeedbackById(int feedbackId){
        FeedbackRepository.deleteFeedbackById(feedbackId);
    }
}