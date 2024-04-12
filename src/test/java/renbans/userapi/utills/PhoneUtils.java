package renbans.userapi.utills;


import renbans.userapi.entity.Phone;
import renbans.userapi.enums.PhoneType;
import renbans.userapi.dto.request.PhoneDTO;



public class PhoneUtils {
    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO(){
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity(){
        return Phone.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
