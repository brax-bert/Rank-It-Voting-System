<template>
  <div id="login" class='login-container'>
      <img src='../assets/RankItSloganNoBG.png' alt='Image' class='login-logo'/>
    <form v-on:submit.prevent="login" class='login-form'>
      <h1>Login</h1>
      <div role="alert" v-if="invalidCredentials" class='alert-error'>
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration" class='alert-registration'>
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <input type="text" id="username" v-model="user.username" placeholder='Username' class='input-box' required autofocus />
      </div>
      <div class="form-input-group">

        <input :type='passwordFieldType' id="password" v-model="user.password" placeholder='Password' class='input-box' required />
      </div>
      <div class="form-input-group">
        <input type="checkbox" id="showPassword" v-model="showPassword" /> Show Password
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false,
      showPassword: false
    };
  },
  computed: {
    passwordFieldType() {
      return this.showPassword ? 'text' : 'password';
    }
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/issues");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

h1 {
  text-align: center;
  padding-top: 15px;
  padding-bottom: 5px;

}

.login-container {
  text-align: center;
  padding-bottom: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #E4E4E4;
  height: 100vh;
  font-family: Arial, Helvetica, sans-serif;
  padding-bottom: 40x;
}

.login-form {
  height: 200px;
  background-color: #c9c9c6; /* For browsers that do not support gradients */
  background-image: linear-gradient(#77a5c4, #FFDB15);
  box-shadow: 0 2px 10px #020301;
  height: 400px;
  width: 350px;
  border-radius: 40px;
  padding-bottom: 40x;
  
}

label {
  display: block;
  font-weight: bold
}

button {
  padding: 10px;
  border-radius: 10px;
  background-color: #8FA9B1;
  font-size: 15px;
  font-family: Arial, Helvetica, sans-serif;
  transition: background-color 0.3s ease;
}
button:hover {
  background-color: #FFDB15;
}
.input-box {
  border-radius: 15px;
  padding: 12px;
}
.alert-registration {
  margin:30px;

}

.sign-up {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 20px;
}

</style>