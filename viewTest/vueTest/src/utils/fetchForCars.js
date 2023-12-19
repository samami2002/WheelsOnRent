
export async function getAllCars() {
 
    const URL = 'http://localhost:8091/cars'
    const cars = await fetchUrl(URL)
    console.log('cars: ' + cars)
    return cars
}

export async function getAllBrands() {
    
    const URL = 'http://localhost:8091/cars/get-all-brands'
    const brand = await fetchUrl(URL)
    console.log('brand:s ' + brand)
    return brand
}

export async function getModelsByBrand()
{
    const URL = 'http://localhost:8091/cars/get-model-by-brand?brand=Volvo'
    const brand = await fetchUrl(URL)
    console.log('brand:s ' + brand)
    return brand
    
}

async function fetchUrl(URL){

    
    const resp = await fetch(URL, { headers: { 'Accept': 'application/json' } })

    if (!resp.ok) {
        console.log('Not found')
        return { ERROR: "Bad Request"}
    }
    
    const myjson = await resp.json()
    console.log(myjson)
    return myjson

}