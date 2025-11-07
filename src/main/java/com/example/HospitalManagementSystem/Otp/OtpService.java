package com.example.HospitalManagementSystem.Otp;

import com.example.HospitalManagementSystem.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
@RequiredArgsConstructor
public class OtpService {
   private final Map<String ,OtpData> otpStorage = new ConcurrentHashMap<>();

   private static class OtpData {
       String code;
       Instant expiry;

       OtpData(String code, Instant expiry) {
           this.code = code;
           this.expiry = expiry;
       }
   }

   public String generateOtp(String email){
       SecureRandom random = new SecureRandom();
       String otp = String.valueOf(100000 + random.nextInt(900000));
       otpStorage.put(email,new OtpData(otp,Instant.now().plusSeconds(300)));
   return otp;

   }

   //validate otp
    public boolean validateOtp(String email,String otp){
       OtpData data = otpStorage.get(email);
       if(data == null) throw new BadRequestException("No Otp found for this email");

       if(data.expiry.isBefore(Instant.now())){
           otpStorage.remove(email);
           throw new BadRequestException("Otp expired");
       }

       if(!data.code.equals(otp))
           throw new BadRequestException("Invalide OTP");

       otpStorage.remove(email);
       return true;
    }

    public void invalidOtp(String email){
       otpStorage.remove(email);
    }

}
