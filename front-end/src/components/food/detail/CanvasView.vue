<template>
  <canvas id="myChart"></canvas>
</template>

<script>
/* eslint-disable */
import Chart from "chart.js/auto";
export default {
  data() {
    return {
    //   name: "HelloWorld",
    //   width: 500,
    //   height: 600,
    //   info: false,
    //   marker: null,
    //   count: 1,
    //   map: null,
    //   isCTT: false,
    //   mapOptions: {
    //     lat: 35.1525133,
    //     lng: 129.059547,
    //     zoom: 15,
    //     zoomControl: true,
    //     zoomControlOptions: { position: "TOP_RIGHT" },
    //     mapTypeControl: true,
    //   },
    //   initLayers: [
    //     "BACKGROUND",
    //     "BACKGROUND_DETAIL",
    //     "POI_KOREAN",
    //     "TRANSIT",
    //     "ENGLISH",
    //     "CHINESE",
    //     "JAPANESE",
    //   ],

      chartData: {
        labels: ["맛", "서비스", "접근성", "분위기", "가성비"],
        datasets: [
          {
            label: "여성",
            data: [5, 3, 1, 4, 2],
            fill: true,
            backgroundColor: "rgba(255, 99, 132, 0.2)",
            borderColor: "rgb(255, 99, 132)",
            pointBackgroundColor: "rgb(255, 99, 132)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgb(255, 99, 132)",
          },
          {
            label: "남성",
            data: [1, 5, 3, 3, 4],
            fill: true,
            backgroundColor: "rgba(54, 162, 235, 0.2)",
            borderColor: "rgb(54, 162, 235)",
            pointBackgroundColor: "rgb(54, 162, 235)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgb(54, 162, 235)",
          },
        ],
      },
    };
  },
  mounted() {
    const ctx = document.getElementById("myChart");

    new Chart(ctx, {
      type: "radar",
      data: this.chartData,
      options: {
        elements: {
          line: {
            borderWidth: 3,
          },
        },
        scales: {
            r: {
                angleLines: {
                    display: false
                },
                suggestedMin: 0,
                suggestedMax: 5,
                ticks: {
                    stepSize: 1,
                    z : 5,
                    backdropColor : 'rgba(255, 255, 255, 0.25)',
                },
            }
        }
      },
    });
    options = {
   
};
  },
};
</script>

<style></style>
