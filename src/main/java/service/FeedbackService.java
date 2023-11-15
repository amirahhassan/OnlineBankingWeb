package service;

import entity.Feedback;
import repository.FeedbackRepository;

public class FeedbackService {
    public static void addNewFeedback(Feedback feedback){
        FeedbackRepository.addNewFeedback(feedback);
    }

    public static void listAllFeedback(){
        FeedbackRepository.listAllFeedback();
    }
}
