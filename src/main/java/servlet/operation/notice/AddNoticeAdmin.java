package servlet.operation.notice;

import entity.Feedback;
import entity.Notice;
import service.FeedbackService;
import service.NoticeService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addNoticeAdmin")
public class AddNoticeAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userMsg = req.getParameter("noticeMessage");
        String userId = req.getParameter("userId");

        Notice notice = new Notice();
        notice.setNotice(userMsg);
        notice.setUserId(userId);

        boolean isSuccess = NoticeService.addNewNotice(notice);
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        if (isSuccess){
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}