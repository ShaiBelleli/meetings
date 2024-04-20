package com.shaibal.meetings.repositories;

import com.shaibal.meetings.models.entities.MeetingAttendanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingAttendanceRequestRepository extends JpaRepository<MeetingAttendanceRequest, String> {
}
