package com.jamong;

import java.util.*;

public class RecommendationEngine {
    
    // Recommendation logic is encapsulated in this class
    public String recommend(String gender, String ageGroup, int numberOfChildren, String device, String preferredCountry) {
        
        // Recommendation rules
        if (ageGroup.equals("40대")) {
            return "40s Hits";
        } else if (gender.equals("여") && ageGroup.equals("20대") && device.equals("아이폰")) {
            return "K-pop Favorites";
        } else if (gender.equals("남") && ageGroup.equals("50대")) {
            return "Classic Rock";
        } else if (ageGroup.equals("10대")) {
            return "Teen Pop Essentials";
        } else if (preferredCountry.equals("유럽")) {
            return "European Indie";
        } else {
            return "Global Top Charts";
        }
    }
    
}
