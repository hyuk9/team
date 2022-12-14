<template>
  <div id="app">
    <NavCom v-if="wantToShow()" />
    <router-view />
    <FooterCom v-if="wantToShow()" />
    <!-- <div id="app">
      <NavCom />
      <router-view />
      <FooterCom />
    </div> -->
  </div>
</template>


<script>
import NavCom from "@/components/common/NavCom.vue";
import FooterCom from "@/components/common/FooterCom.vue";
export default {
  methods: {
    wantToShow() {
      if (this.$route.name == "login") {
        return false;
      } else {
        return true;
      }
    },
  },
  components: {
    NavCom,
    FooterCom,
  },
};
</script>

<style lang="scss">
h1, span {
  font-family: ONE-Mobile-POP;
}

@font-face {
  font-family: 'ONE-Mobile-POP';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/ONE-Mobile-POP.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
</style>
