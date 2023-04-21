package com.qa.springlearning.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Tells spring it's a table
public class Cat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // makes it auto-increment
  private Long id;

  private String name;
  private boolean hasWhiskers;
  private boolean evil;
  private double length;
  private boolean hasThumbs;

  public Cat() {}

  public Cat(
    String name,
    boolean hasWhiskers,
    boolean evil,
    double length,
    boolean hasThumbs
  ) {
    this.name = name;
    this.hasWhiskers = hasWhiskers;
    this.evil = evil;
    this.length = length;
    this.hasThumbs = hasThumbs;
  }

  public Cat(
    Long id,
    String name,
    boolean hasWhiskers,
    boolean evil,
    double length,
    boolean hasThumbs
  ) {
    this.id = id;
    this.name = name;
    this.hasWhiskers = hasWhiskers;
    this.evil = evil;
    this.length = length;
    this.hasThumbs = hasThumbs;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isHasWhiskers() {
    return hasWhiskers;
  }

  public void setHasWhiskers(boolean hasWhiskers) {
    this.hasWhiskers = hasWhiskers;
  }

  public boolean isEvil() {
    return evil;
  }

  public void setEvil(boolean evil) {
    this.evil = evil;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public boolean isHasThumbs() {
    return hasThumbs;
  }

  public void setHasThumbs(boolean hasThumbs) {
    this.hasThumbs = hasThumbs;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + (hasWhiskers ? 1231 : 1237);
    result = prime * result + (evil ? 1231 : 1237);
    long temp;
    temp = Double.doubleToLongBits(length);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + (hasThumbs ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Cat other = (Cat) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (name == null) {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    if (hasWhiskers != other.hasWhiskers) return false;
    if (evil != other.evil) return false;
    if (
      Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length)
    ) return false;
    if (hasThumbs != other.hasThumbs) return false;
    return true;
  }
}
