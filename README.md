# Car Dealership Invoice Generator

## Overview

The **Car Dealership Invoice Generator** is a Java-based application that models the management and pricing of vehicles, specifically focusing on Chevrolet cars. The program allows users to create different car models, apply various packages (such as luxury, four-wheel drive, and sports packages), calculate the total price of the vehicle with upgrades, and generate detailed invoices. Additionally, it offers functionality to compare vehicles based on mileage and check equality for models with similar features.

### Key Features:
- **Model Customization:** Allows for the customization of car models by selecting different packages (four-wheel drive, luxury, sports).
- **Price Calculation:** Computes the final price of the vehicle based on the selected packages, including taxes and price increases.
- **Comparisons:** Compares two cars by mileage and checks for equality based on model, color, and status.
- **Detailed Invoice:** Generates a formatted invoice including the base price, upgrades, and final total after tax.

## Classes:

### `Chevy`
This class represents a Chevrolet vehicle and contains attributes such as year, mileage, fuel efficiency, and base price. It also includes logic for calculating the price with applied upgrades (e.g., four-wheel drive, luxury, sports package) and generating the final invoice.

- **Attributes:**
  - `year`: Model year of the car.
  - `mileage`: Mileage of the car.
  - `fuelEff`: Fuel efficiency of the car in miles per gallon.
  - `basePrice`: Base price of the car.
  - `model`: Model name (e.g., Silverado, Equinox, Corvette).
  - `color`: Car color (e.g., Black, Blue, Red).
  - `fourWDPackageStatus`: Whether the car has a four-wheel drive package.
  - `sportsPackageStatus`: Whether the car has a sports package.
  - `luxuryPackageStatus`: Whether the car has a luxury package.
  - `priceWithUpgrades`: Price after considering all applied upgrades.
  - `grandTotal`: Final price with tax.

- **Methods:**
  - `calcPrice()`: Calculates the total price based on the base price and selected packages.
  - `toString()`: Returns a detailed string representation of the car's specifications and pricing.
  - `compareTo()`: Compares mileage between two cars.
  - `equals()`: Checks for equality between two cars based on their model, color, and status.

### `ChevyDriver`
This is the main driver class that demonstrates the functionality of the `Chevy` class. It creates various instances of Chevy cars, updates their properties, compares their mileage, checks for equality, and prints the vehicle details and invoice.

## Usage:

1. **Creating Vehicles:**
   - The `Chevy` class allows for the creation of different Chevrolet vehicles with custom attributes such as year, mileage, model, and packages.
   - Users can specify whether a vehicle has the four-wheel drive, luxury, or sports package.

2. **Price Calculation:**
   - The `calcPrice()` method calculates the price of the car with selected upgrades. The price is further adjusted by a tax rate.

3. **Invoice Generation:**
   - The `toString()` method generates a detailed invoice for the car, including base price, mileage, fuel efficiency, applied packages, and the final price after tax.

4. **Comparison of Vehicles:**
   - The `compareTo()` method is used to compare vehicles based on their mileage.
   - The `equals()` method checks if two vehicles are identical based on their model, color, and usage status.

How to Run:

1. Clone this repository to your local machine.
2. Open the project in your favorite Java IDE (such as IntelliJ IDEA or Eclipse).
3. Compile and run the ChevyDriver class.
4. View the generated invoice and car comparisons in the console.



