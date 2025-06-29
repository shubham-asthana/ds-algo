✅ LLD Interview Cheat-Sheet
🚗 Example: Parking Lot Design

🥇 MVP (Minimal Viable Product) — Must Design & Implement
Component Responsibility
Vehicle Type of vehicle (Car, Bike, Truck), vehicle number
ParkingSpot Type of spot (small, medium, large), availability, spot ID
ParkingFloor Collection of parking spots
Ticket Contains vehicle details, entry time, ticket ID
Gate (Entry/Exit) Entry: issues ticket
Exit: calculates fees & frees up spot
ParkingLot Aggregates floors, handles vehicle entry & exit
SpotManager Helps find first available spot based on vehicle type
FeeCalculator (Simple) flat or hourly fee calculation

👉 Design tip: Make SpotManager and FeeCalculator interfaces with one concrete strategy for MVP.

💡 MVP Must-Have Validations
No two vehicles with same plate

No double parking

Spot type matches vehicle type

Spot must be available

Calculate fee before un-parking

🌱 Possible Follow-Ups (Just Explain / Sketch)
Feature What to say
Reservations Can extend SpotManager with time-based filtering
Multiple Pricing Strategies Strategy Pattern for FeeCalculator
Multiple Lots / Cities ParkingLotService layer + registry for all lots
Undo/Replay (e.g. TicTacToe) Command pattern or storing moves/history
Gate Concurrency Add locking or distributed state syncing
Notifications / Alerts Pub/Sub event-based extensibility

💬 What to Say in Interview
“Let me start with the MVP covering key flows like parking and un-parking. I’ll build it using extensible abstractions so that features like dynamic pricing, reservations, or multiple gates can be easily plugged in later.”

🎯 Final Advice
Think in layers: entities → services → strategies → flows.

Name things clearly: avoid vague names like Manager, prefer SpotAssignmentStrategy, etc.

Build first, then extend: Interviewers value progress + clarity over premature complexity.
