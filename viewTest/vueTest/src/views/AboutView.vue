<template>
<div v-for="model in modelsByBrand" .key="model.id">
        <p>{{ model }}</p>
</div>
<div id="selector">
  <select v-model="selected">
    <option v-for="brand in allBrands" :value="brand.id">
      {{ brand }}
    </option>
  </select>
  <br>
  <br>
  <span>Selected: {{ selected }}</span>
</div>

  
</template>


<script>
import { getAllCars } from "../utils/fetchForCars"
import { getAllBrands } from "../utils/fetchForCars"
import { getModelsByBrand } from "../utils/fetchForCars"
export default {

  data() {
    return {
      allCars: [],
      allBrands: [],
      modelsByBrand: []
    }

  },
  async created() {
    this.allCars = await  getAllCars()
    this.allBrands = await getAllBrands()
    this.modelsByBrand = await getModelsByBrand()
  },
}
</script>

../utils/cars../utils/fetchForCars../utils/fetchForCars