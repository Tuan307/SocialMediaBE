package com.social.app.repository.feature_report;

import com.social.app.model.feature_post_image.PostItem;
import com.social.app.model.feature_report.ReportModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<ReportModel, Long> {
}
