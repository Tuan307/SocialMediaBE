package com.social.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddStoryFolderDTO {
    private String name;
    private String folderAvatar;
    private String createdAt;
    private String userId;
}
