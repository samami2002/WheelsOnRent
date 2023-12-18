
export async function getAllcars() {
 
    const URL = 'http://localhost:8091/cars'
    const resp = await fetch(URL, { headers: { 'Accept': 'application/json' } })

    if (!resp.ok) {
        console.log('Not found')
    }
    
    const myjson = await resp.json()
    console.log(myjson)
    return myjson
}