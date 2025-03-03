package com.streamwork.ch04.job;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ScoreStorage is a class to simulate a very basic key-value store using a hashmap object.
 */
class ScoreStorage implements Serializable {
  private static final long serialVersionUID = -1157146960334381327L;
  Map<String, Float> transactionScores = new ConcurrentHashMap<>();

  public ScoreStorage() {}

  /**
   * Get the score of a transaction.
   * @param transaction
   * @param defaultValue
   * @return
   */
  float get(String transaction, float defaultValue) {
    Float value = transactionScores.get(transaction);
    if (value == null) {
        return defaultValue;
    }
    return value;
  }

  void put(String transaction, float value) {
    Logger.log("Transaction score change: " + transaction + " ==> " + value + "\n");
    transactionScores.put(transaction, value);
  }
}
