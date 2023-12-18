<template>
<div v-for="car in allcars" .key="car.id">
        <p>{{ car.model }}</p>
</div>
<div id="selector">
  <select v-model="selected">
    <option v-for="car in allcars" :value="car.id">
      {{car.model}}
    </option>
  </select>
  <br>
  <br>
  <span>Selected: {{ selected }}</span>
</div>
  
</template>


<script>
import { getAllcars } from "../utils/serverTest"
export default {

  data() {
    return {
      allcars: []
    }

  },
  async created() {
    this.allcars = await  getAllcars()
   
  },
}
</script>

