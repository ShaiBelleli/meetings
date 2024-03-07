package com.shaibal.meetings.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "meetings_users")
public class MeetingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @Column(name = "attendee_display_name")
    private String attendeeDisplayName;

    @Column(name = "pending_attendee_display_name")
    private String pendingAttendeeDisplayName;
}