package com.wonder.wonder.dto.conerter;

import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.User;
/**
 * Created b.missurenko
 * Date **.12.17.
 */
public interface EventConverter {
    EventDto convertToDto(Event event);
    Event convertToEntity(EventDto eventDto);
}
