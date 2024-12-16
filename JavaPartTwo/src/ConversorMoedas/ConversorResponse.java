package ConversorMoedas;

import com.google.gson.annotations.SerializedName;

public record ConversorResponse(
                     String base_code,
                     String target_code,
                     double conversion_result) {

}
