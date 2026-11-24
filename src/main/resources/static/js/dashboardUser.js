/*Dashboard User*/
const  searchInput = document.getElementById('searchInput');
const cardRecipe = document.querySelectorAll('.cardRecipe');


/*cari resep */
searchInput.addEventListener('input',(event)=>{
    const kataKunci = event.target.value.toLowerCase();
    
     cardRecipe.forEach((event)=>{
        const hasilCarian = event.querySelector('.judulResep').textContent.toLowerCase();
        event.style.display = hasilCarian.includes(kataKunci) ? '' : 'none';
    });
});
