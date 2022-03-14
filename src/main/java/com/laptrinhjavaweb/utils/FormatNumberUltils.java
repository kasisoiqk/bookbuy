package com.laptrinhjavaweb.utils;

import java.text.DecimalFormat;

public class FormatNumberUltils {

	public static String priceToString(Long price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(price);
    }
    
    public static String formatToNumber(String price) {
        return price.trim().replaceAll("\\D", "");
    }
	
}
