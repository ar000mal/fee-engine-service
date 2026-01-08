# Fee Engine Service

A Spring Boot backend application that calculates banking fees using a
rule-based approach. The system evaluates configurable business rules
to determine the final fee for an account.

---

## Overview

This service accepts account details through a REST API, applies fee rules
based on the provided data, and returns the calculated fee along with the
rules that were applied.

---

## Features

- Rule-based fee calculation
- Clean layered architecture
- Premium customer fee exemption
- Low balance fee handling
- Easily extendable rule design

---

## Architecture

Controller → Service → Rule Engine → Rules
---

## Tech Stack

- Java 17
- Spring Boot
- Maven
- REST API

---

## API Endpoint

### Calculate Fee

**POST**
http://localhost:8080/fees/calculate
### Request Body
```json
{
  "accountId": "ACC101",
  "productType": "SAVINGS",
  "customerType": "REGULAR",
  "balance": 3000
}

###Response

{
  "totalFee": 100,
  "appliedRules": ["LOW_BALANCE_FEE"]
}

###
---
Rules Implemented

LOW_BALANCE_FEE – Applied when account balance is below the minimum threshold

PREMIUM_CUSTOMER – Overrides all other rules and applies zero fee

## How to Run

mvn spring-boot:run


The application runs on port 8080.

## Testing

The API can be tested using tools like Postman by sending a POST request
to /fees/calculate with a JSON request body.