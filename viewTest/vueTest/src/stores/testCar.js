import { defineStore } from 'pinia'

export const useRuneStore = defineStore('car', {
    state: () => ({
        url: "",
        imgUrl: "",
    }),
    actions: {
        //sets new active rune with object url, and image url
        updateRune(url, imgUrl) {
            this.url = url
            this.imgUrl = imgUrl
        }
    },

})