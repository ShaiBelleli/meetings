package com.shaibal.meetings.mappers;

public interface IMapper<R, S> {
    R map(S src);
}
