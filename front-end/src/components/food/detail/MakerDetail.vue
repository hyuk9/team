<template>
  <div class="mapDetail">
      <div id="map"></div>
        <button type="button" class="btn btn-dark mt-3 btn-lg" @click="link()"><i class="bi bi-search"></i></button>
  </div>
</template>
  
  
  <script>
import DinerDataService from "@/services/DinerDataService";

/* eslint-disable */
export default {
  name: "mapDetail",
  data() {
    return {
      diner: [],
      currentDiner: null,
    };
  },
  mounted() {
    alert(this.currentDiner.lat),
    alert(this.currentDiner.lng),
    this.getDiner(this.$route.params.dno);
    window.kakao && window.kakao.maps
      ? this.initMap()
      : this.addKakaoMapScript();
  },
  methods: {
    // 부서번호(dno)로 조회 요청하는 함수
    getDiner(dno) {
      // axios 공통함수 호출
      DinerDataService.get(dno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentDiner = response.data;
          // 콘솔 로그 출력
          console.log("현재 음식점 데이터 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    link() {
        window.open(`https://map.kakao.com/link/search/${this.currentDiner.dname}`)
    },
    addKakaoMapScript() {
      const script = document.createElement("script");
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=c8bb9778f822e59259dd0cca144c3fd1";
      document.head.appendChild(script);
    },
    initMap() {
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(this.currentDiner.lat, this.currentDiner.lng), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };

      var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

      // 마커를 표시할 위치와 title 객체 배열입니다
      var positions = [
        {
          latlng: new kakao.maps.LatLng(this.currentDiner.lat, this.currentDiner.lng),
        },
      ];

      // 마커 이미지의 이미지 주소입니다
      var imageSrc =
        "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

      for (var i = 0; i < positions.length; i++) {
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35);

        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: positions[i].latlng, // 마커를 표시할 위치
          image: markerImage, // 마커 이미지
        });
      }
    },
  },
};
</script>
  
  
  <style scoped>
.mapDetail {
  height: 80vh;
  text-align: center;
}

#map {
  width: 430px;
  height: 500px;
  border: 1px #a8a8a8 solid;
}
</style>