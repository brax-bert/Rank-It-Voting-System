<template>
  <div id="capstone-app">
   
    <div id="topnav">
      <a href="/">
        <img src="src/assets/RankItWhiteNoBG.png" alt="Logo" id="logo">
        <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
      </a>
      <!-- <div id="right-links"> -->
        <router-link :to="{ name: 'explore' }">Explore</router-link>
        <router-link :to="{ name: 'issues' }">Issues</router-link>
        <router-link v-if="isAdmin" :to="{ name: 'createissue' }">Admin Portal</router-link>
      <!-- </div> -->
      <div id="right-links">
        <template v-if="isAuthenticated">
        <router-link :to="{ name: 'votes'}">My Profile</router-link>

        <router-link :to="{ name: 'logout' }">Logout</router-link>

        </template>
        <template v-else>
          <router-link :to="{ name: 'login' }">Sign up or Log In</router-link>
         
        </template>
      </div>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  computed: { 
    isAdmin() {
      return this.$store.state.user.authorities?.[0]?.name === 'ROLE_ADMIN';
    },
    isAuthenticated() {
      return this.$store.getters.isAuthenticated;
    }
  }
};
</script>

<style scoped>
body{
  font-family: Arial, Helvetica, sans-serif;
  
}

#topnav {
  overflow: hidden;
  background-color: #020301;
  display: flex;
  /* justify-content: space-between; */
  align-items: center;
}
#topnav a {
  color: #E4E4E4;
  text-decoration: none;
  padding: 14px 16px;
  font-family: Arial, Helvetica, sans-serif;
}
#topnav a:hover {
  background-color: #020301;
  color: #8FA9B1;
 
}
#logo {
  height: 50px;
  margin-left: 150px;
}
#right-links {
  position: absolute;
  right: 100px;
}
</style>