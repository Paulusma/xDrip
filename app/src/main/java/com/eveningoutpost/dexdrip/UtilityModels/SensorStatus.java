package com.eveningoutpost.dexdrip.UtilityModels;

import com.eveningoutpost.dexdrip.Models.JoH;
import com.eveningoutpost.dexdrip.Models.Sensor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.eveningoutpost.dexdrip.Models.JoH.tsl;

// jamorham

public class SensorStatus {

    // TODO i18n
    public static String status() {
        final StringBuilder sensor_status = new StringBuilder();
        if (Sensor.isActive()) {
            //!!!PMA using sensorage from preference iso sensor: after all this is what xDrip shows in overview
            final int sensor_age = Pref.getInt("nfc_sensor_age", 0);
            sensor_status.append((Pref.getBooleanDefaultFalse("nfc_age_problem") ? "Age:  unknown" :
                    "Age: " + JoH.qs(((double) sensor_age) / 1440, 1) + "d"));
        } else {
            sensor_status.append("not available");
        }
        return sensor_status.toString();
    }

}