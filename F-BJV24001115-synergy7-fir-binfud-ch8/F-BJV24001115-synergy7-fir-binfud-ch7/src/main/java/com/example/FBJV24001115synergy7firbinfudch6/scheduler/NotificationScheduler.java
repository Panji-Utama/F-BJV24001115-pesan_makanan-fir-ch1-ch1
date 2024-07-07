package com.example.FBJV24001115synergy7firbinfudch6.scheduler;

import com.example.FBJV24001115synergy7firbinfudch6.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationScheduler {

    @Autowired
    private NotificationService notificationService;

    @Scheduled(cron = "* 15 4 * * ?")
    public void sendMidnightPromotion() {
        // Assuming you have a way to get user tokens
        String userToken = "fdW_cPZZzBFGFkyikiAU37:APA91bFV8RGQg8l9ULg8mb41VOKfG9-c3pHrD_JN1xsRMIsW_DC-za1U8IFg8MVEw625J8SoeD8lXtOEPnXXQkpIzOSYGWmviNTnsqoVewk3Bm9alHIPZJowzjgFu14UGODVxwAEvSVL";
        String title = "Promo Tengah Malam";
        String body = "Sekarang sudah jam 4 pagi, terdapat promo tengah malam spesial untukmu";

        notificationService.sendNotification(userToken, title, body);
    }
}
