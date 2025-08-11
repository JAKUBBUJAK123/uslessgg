# UslessGG 🎮

A League of Legends funny performance tracking application that analyzes your gameplay and rates how "useless" you are based on role-specific metrics. Built with Spring Boot and integrated with the Riot Games API.

## 🌟 Features

- **Summoner Search**: Look up players by Riot ID (GameName#TagLine)
- **Multi-Region Support**: EUW, EUNE, NA, KR, BR
- **Role-Based Scoring**: Different scoring algorithms for each position:
  - **Jungle**: Objectives, vision, enemy camps, dragon kills
  - **ADC/Mid**: Damage, CS, kills, multi-kills, killing sprees
  - **Top**: Turret damage, CS, gold efficiency
  - **Support**: Vision score, assists, utility metrics
- **Ranked Information**: Current league standings and LP

## 🚀 Tech Stack

- **Backend**: Spring Boot 3.5.4, Java 17
- **Frontend**: Thymeleaf templates, CSS3
- **API Integration**: Riot Games API, Data Dragon
- **Build Tool**: Maven
- **Dependencies**: Spring WebFlux, Lombok, Spring DevTools

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- Riot Games API key

## ⚙️ Setup

### 1. Clone the Repository
```bash
git clone <your-repo-url>
cd uslessgg
```

### 2. Get Riot Games API Key
1. Visit [Riot Developer Portal](https://developer.riotgames.com/)
2. Sign up and create an application
3. Copy your API key

### 3. Configure API Key
Edit `src/main/resources/application.properties`:
```properties
riot.api.key=YOUR_API_KEY_HERE
```

### 4. Build and Run
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 🎯 Usage

### Home Page
1. Navigate to the home page
2. Select your region (EUW, EUNE, NA, KR, BR)
3. Enter your Riot ID:
   - **Game Name**: Your summoner name
   - **Tag Line**: The part after the # (e.g., "Summoner#NA1")

### Results Page
After searching, you'll see:
- **Summoner Info**: Level, profile details
- **Ranked Stats**: Current league standings
- **Match History**: Recent games with performance scores
- **Performance Rating**: Your "uselessness" tier for each game

## 🌍 Supported Regions

- **EUW** (Europe West)
- **EUNE** (Europe Nordic & East)
- **NA** (North America)
- **KR** (Korea)
- **BR** (Brazil)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments

- **Riot Games** for providing the League of Legends API
- **Spring Boot** team for the excellent framework
- **Data Dragon** for game data

---

**Note**: This application is for entertainment purposes. The "useless" ratings are meant to be fun and should not be taken seriously as a measure of actual skill!

**Disclaimer**: This application is not affiliated with or endorsed by Riot Games.
