package com.social.app.model.feature_group.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateGroupPostItem {
    private String id;
    private String description;
    private List<String> imagesList;
    private String userId;
    private Long groupId;
    private String createdAt;
    private String checkInAddress;
    private Double checkInLatitude;
    private Double checkInLongitude;
    private String type;
    private String videoUrl;
    private String question;
}
