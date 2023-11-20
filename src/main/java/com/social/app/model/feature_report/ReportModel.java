package com.social.app.model.feature_report;

import com.social.app.model.feature_post_image.PostItem;
import com.social.app.model.feature_user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report")
@Setter
@Getter
public class ReportModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_report")
    private User userReport;
    @Column(name = "report_date")
    private String reportDate;
    @Column(name = "report")
    private String report;
    @Column(name = "number_report")
    private Integer numberReport;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_post_id", referencedColumnName = "post_id")
    private PostItem postItem;
}
