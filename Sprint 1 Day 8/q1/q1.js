const weatherData = {
  India: { icon: "☀️", temp: "32°C", desc: "Sunny and hot" },
  France: { icon: "🌧️", temp: "18°C", desc: "Light rain" },
  Japan: { icon: "⛅", temp: "24°C", desc: "Partly cloudy" },
  Canada: { icon: "❄️", temp: "-5°C", desc: "Snowy" }
};

document.getElementById("cityInput").addEventListener("keydown", function (e) {
  if (e.key === "Enter") {
    const country = e.target.value.trim();
    const details = weatherData[country];

    const weatherInfo = document.getElementById("weatherDetails");

    if (details) {
      weatherInfo.innerHTML = `
        <div class="weather-icon">${details.icon}</div>
        <div class="weather-info">
          <h2>${country}</h2>
          <p>${details.temp} | ${details.desc}</p>
        </div>
      `;
    } else {
      weatherInfo.innerHTML = `
        <div class="weather-icon">❓</div>
        <div class="weather-info">
          <h2>Not Found</h2>
          <p>No weather data for "${country}".</p>
        </div>
      `;
    }
  }
});
