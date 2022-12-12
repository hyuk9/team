<template>
  <div>
    <NavCom v-if="wantToShow()"/>
    <router-view />
    <FooterCom v-if="wantToShow()" />
  </div>
</template>

<script>
import NavCom from "@/components/common/NavCom.vue";
import FooterCom from "@/components/common/FooterCom.vue";

export default {
  methods: {
    wantToShow() {
      if(this.$route.name == "login") {
        return false;
      } else {
        return true;
      }
    }
  },
  components: {
    NavCom,
    FooterCom
  },
};
</script>

<style lang="scss">

</style>
