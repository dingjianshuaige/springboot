package com.tanghaohang.bs.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanghaohang.bs.entity.Records;
import com.tanghaohang.bs.mapper.RecordsMapper;
import com.tanghaohang.bs.service.RecordsService;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class RecordsServiceImpl extends ServiceImpl<RecordsMapper, Records> implements RecordsService {

    @Override
    public int belongtime(Time nowTime) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");


        Date beginTime = null;
        Date endTime = null;
        Date beginTime2 = null;
        Date endTime2 = null;
        Date beginTime3 = null;
        Date endTime3 = null;
        Date beginTime4 = null;
        Date endTime4 = null;
        Date beginTime5 = null;
        Date endTime5 = null;

        int cls = 0;
        try {
            beginTime = df.parse("8:00:00");
            endTime = df.parse("9:40:00");
            beginTime2 = df.parse("9:55:00");
            endTime2 = df.parse("11:35:00");
            beginTime3 = df.parse("14:30:00");
            endTime3 = df.parse("16:10:00");
            beginTime4 = df.parse("16:25:00");
            endTime4 = df.parse("18:05:00");
            beginTime5 = df.parse("19:00:00");
            endTime5 = df.parse("20:40:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (belongCalendar(nowTime, beginTime, endTime)) {cls = 1;}
        else if (belongCalendar(nowTime, beginTime2, endTime2)) {cls = 2;}
        else if (belongCalendar(nowTime, beginTime3, endTime3)) {cls = 3;}
        else if (belongCalendar(nowTime, beginTime4, endTime4)) {cls = 4;}
        else if (belongCalendar(nowTime, beginTime5, endTime5)) {cls = 5;}

        return cls;
    }



    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if(date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

}
