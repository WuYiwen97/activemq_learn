import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class mytest {


    @Test
    public void afs(){
        mytest mytest = new mytest();
        try {
            mytest.test();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test() throws ParseException {
        long l = System.currentTimeMillis();
        Date  date = new Date();
        System.out.println(date);
        System.out.println(date.toString());
        System.out.println(date.getTime());


        Timestamp timestamp = new Timestamp(12341241241234L);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = new Date();

        String format = simpleDateFormat.format(date1);
        System.out.println(format);

        String dd ="202s";
        Date parse = simpleDateFormat.parse(dd);
        java.sql.Date date2 = new java.sql.Date(parse.getTime());
        System.out.println(parse);

        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH,3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        Date time = calendar.getTime();
        System.out.println(time);

        Date date3 = new Date();
        calendar.setTime(date3);
        System.out.println();


    }



    @Test
    public void test11(){


        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);


        //of() 指定时间
        LocalDateTime of = LocalDateTime.of(2021, 6, 7, 13, 23, 2);
        System.out.println(of);

        //get 属性
        localDateTime.getDayOfMonth();
        localDateTime.getMonth();
        localDateTime.getMonthValue();

        //with == set
        //原来的没有改变 返回新的值
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(1);
        System.out.println(localDateTime1);
        System.out.println(localDateTime);

        //plus == add
        LocalDateTime localDateTime2 = localDateTime.plusMonths(1);

        //minus
        localDate.minusDays(2);

        System.out.println("---");
        System.out.println(Instant.now());

        Instant now = Instant.now();
        //北京时间
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));

        System.out.println(offsetDateTime.toEpochSecond());
        System.out.println(now);
        System.out.println(now.toEpochMilli());

        Instant instant = Instant.ofEpochMilli(1629554731L);
        System.out.println(instant);

    }


    @Test
    public void dsfas(){

        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String format = isoLocalDateTime.format(now);
        System.out.println(format);
        TemporalAccessor parse = isoLocalDateTime.parse(format);
        System.out.println(parse);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(dateTimeFormatter.format(LocalDate.now()));
    }
}
