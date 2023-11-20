package com.social.app.model.feature_report;

import com.social.app.model.feature_post_image.PostItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReportRequest {
    private String userId;
    private String reportDate;
    private String report;
    private PostItem postId;
}
