package com.example.evolent.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Loggable {
  default Logger getLogger() {
    return LoggerFactory.getLogger(this.getClass());
  }
}
