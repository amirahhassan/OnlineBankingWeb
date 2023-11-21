package service;

import dto.UserNotice;
import entity.Notice;
import repository.NoticeRepository;

import java.util.List;

public class NoticeService {
    public static boolean addNewNotice(Notice notice){
        return NoticeRepository.addNewNotice(notice);
    }
    public static List<UserNotice> getAllNoticesByUserId(int id){
        return NoticeRepository.getAllNoticesByUserId(id);
    }
}