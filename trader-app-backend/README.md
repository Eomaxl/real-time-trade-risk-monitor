# Trader App - User Scenarios

1. Login/Authentication
    - User authenticates using credentials (username/password, 2FA, or certificate).
    - Secure session established (mTLS or SSL).
2. Dashboard Landing
    - User sees positions, order history, live order status, and P&L.
    - See system status (FIX connection health).
3. Order Entry
    - Place new orders: Market, Limit, Stop, etc.
    - Specify instrument, side (buy/sell), quantity, price, TIF (Time-in-Force), and account.
    - Preview margin/capital impact (optional).
4. Order Management
    - View, modify, or cancel open orders.
    - Bulk cancel or replace orders.
    - View order lifecycle (pending, filled, partially filled, rejected).
5. Market Data Subscriptions
    - Subscribe/unsubscribe to real-time market data for specific instruments.
    - Display live bid/ask, LTP (Last Traded Price), volume, etc.
6. Execution Reports Handling
   - Real-time notification of order fills, rejections, or partial fills.
   - Download/Export execution reports.
7. Risk & Compliance Notices
    - Get notified if any order is flagged, held, or rejected by risk service.
    - Show pre-trade checks and margin requirements.
8. Session Management
    - Reconnect on session drop.
    - View connection status, logs, and error messages.
9. Audit & Logging
   - Download audit log (all actions, orders, and system messages).
10. User Profile & Settings
    - Update password, notification settings.
    - Set trading preferences (e.g., dark mode, default account).

# Trader App – Feature List

## Features
- User Authentication:<br>
  Login/logout, mTLS/SSL support
- Order Placement:<br>
  Market/Limit/Stop orders, all order params
- Order Modification/Cancellation:<br>
  Amend or cancel existing orders
- Order Book & Trade Blotter:<br>
  View all open, filled, rejected orders
- Market Data Subscription:<br>
  Real-time price updates for instruments
- Execution Report Handling:<br>
  Display and acknowledge trade fills
- Risk Alert Notifications:<br>
  Warnings for risk policy breaches
- Session & Connection Status:<br>
  UI for FIX session state, reconnect button
- Audit Trail Export:<br>
  Downloadable CSV or PDF of user activity
- User Settings:<br>
  Password change, preferences
- Error Handling & Logs:<br>
  Display errors, logs for debugging


##  Extra (Bank-Grade) Features
- Dual Approval Workflow (for high-value trades)
- Pre-trade risk calculation widget
- Trade recap emails / export
- API for algorithmic order flow
- SAML/OAuth2 SSO (for enterprise security)