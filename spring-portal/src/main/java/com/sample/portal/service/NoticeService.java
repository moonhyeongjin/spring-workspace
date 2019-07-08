package com.sample.portal.service;

import java.util.List;

import com.sample.portal.vo.Notice;

public interface NoticeService {

   void addNewNotice(Notice notice);
   List<Notice> getAllNotices();
   Notice getNoticeDetail(int noticeNo);
}