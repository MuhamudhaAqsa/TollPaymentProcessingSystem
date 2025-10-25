# Toll Payment Processing System

A **Java-based Object-Oriented Toll Payment Processing System** designed to simulate toll collection on a circular highway. This project was implemented as part of **Zoho Round 3** technical assessment.

---

## Table of Contents
- [Overview](#overview)  
- [Features](#features)  
- [Modules](#modules)  
- [System Design](#system-design)  
- [Classes](#classes)  
- [How It Works](#how-it-works)  
- [Sample Output](#sample-output)  
- [Getting Started](#getting-started)  
- [Future Enhancements](#future-enhancements)  

---

## Overview

The Toll Payment Processing System allows vehicles to traverse a highway with multiple toll gates, automatically calculating toll charges based on **vehicle type** and **VIP status**. Key highlights:

- Supports **cars, bikes, and trucks**  
- **VIP vehicles** receive a **20% discount** on toll charges  
- Calculates tolls for **regular and circular routes**  
- Tracks revenue at each toll gate  
- Maintains vehicle journey history  

---

## Features

- **Object-Oriented Design**: Modular, scalable, and maintainable code  
- **Flexible Toll Calculation**: Charges configurable per vehicle type  
- **VIP Discounts**: Automatic discount calculation  
- **Circular Highway Support**: Vehicles can traverse in both directions  
- **Comprehensive Reporting**: Displays toll-wise revenue and vehicle-wise journey history  

---

## Modules

1. **Process Journey**: Calculates toll charges for a journey and applies VIP discounts  
2. **Display Toll Details**: Shows vehicles that passed through each toll and revenue collected  
3. **Display Vehicle Details**: Displays each vehicle's journey history and total toll charges  
4. **Find Shortest Route and Calculate Toll**: Determines the shortest circular route between two points and calculates tolls  
5. **Exit**: Terminates the program  

---

## System Design

The system follows **Object-Oriented Programming (OOP) principles**. Key design decisions:

- **Encapsulation**: Each class manages its own data  
- **Modularity**: System broken into small, reusable classes  
- **Abstraction**: Implementation details hidden behind clear interfaces  

**Classes Overview**:  

| Class | Responsibility |
|-------|----------------|
| `Toll` | Represents a toll gate; stores charges, revenue, and vehicle payments |
| `Vehicle` | Stores vehicle details and journey history |
| `Journey` | Represents a single journey with tolls passed and amount paid |
| `VehiclePayment` | Tracks payments made by vehicles at each toll |
| `Highway` | Core system managing toll points, vehicles, and journey processing |
| `TollPaymentSystem` | Main driver class with menu-driven interface for the system |

---

## Classes

### 1. `Toll.java`
Handles toll details, calculates toll based on vehicle type and VIP status, and records vehicle payments.

### 2. `Vehicle.java`
Maintains vehicle information, VIP status, and journey history.

### 3. `Journey.java`
Represents a journey from start to end point, with tolls passed and total amount paid.

### 4. `VehiclePayment.java`
Stores payment details for a vehicle at a specific toll.

### 5. `Highway.java`
Manages all toll points and vehicles, calculates tolls for routes, supports circular highways, and processes journeys.

### 6. `TollPaymentSystem.java`
Main driver class that provides a **menu-driven interface** for processing journeys, displaying toll/vehicle details, and calculating shortest routes.

---

## How It Works

1. **Initialize Tolls**: System sets up tolls with charges for different vehicle types  
2. **Process Journey**: User inputs vehicle details, route, and VIP status. System calculates tolls, applies discounts, and stores journey history  
3. **Display Toll Details**: Shows vehicles that passed through each toll and total revenue collected  
4. **Display Vehicle Details**: Shows journeys, tolls passed, and total toll paid for each vehicle  
5. **Circular Route Support**: Finds shortest forward/backward routes and calculates toll costs  
6. **Exit**: Ends the program  

---

TollPaymentSystem:
  menu:
    - Process Journey
    - Display Toll Details
    - Display Vehicle Details
    - Find Shortest Route and Calculate Toll
    - Exit
  user_choice: 1
  journey:
    vehicle_number: TN01AB1234
    vehicle_type: Car
    is_VIP: true
    start_point: 0
    end_point: 2
    total_toll_paid: 144
  toll_details:
    - toll_id: 0
      vehicles_passed:
        - vehicle_number: TN01AB1234
          paid: 40
      total_revenue: 40
    - toll_id: 1
      vehicles_passed:
        - vehicle_number: TN01AB1234
          paid: 50
      total_revenue: 50
    - toll_id: 2
      vehicles_passed:
        - vehicle_number: TN01AB1234
          paid: 54
      total_revenue: 54
