package com.wonder.wonder.dto.conerter;

import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.User;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.12.2017
 * Project: wonder
 */
public interface EventConverter {
    EventDto convertToDto(Event event);
    Event convertToEntity(EventDto eventDto);
}
