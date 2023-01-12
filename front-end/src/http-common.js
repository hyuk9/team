// http-common.js
//  목적 : springboot 와 axios 통신을 위한 기본 설정
import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8000/api", // 로컬 db에서 가져올 때 사용
  // baseURL: "http://192.168.0.29:8080/api", // 웹 db에서 가져올 때 사용
  headers: {
    "Content-Type": "application/json"
  }
});