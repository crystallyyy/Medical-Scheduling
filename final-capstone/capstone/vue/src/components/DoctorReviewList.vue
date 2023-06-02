<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Number of Reviews</th>
      </tr>
    </thead>
    <tbody>

         <!--  COMMENT   -->
         <!-- need to swap out "product" to something like "office" -->
      <tr v-for="product in $store.state.products" v-bind:key="product.id">
        <td>{{ product.id }}</td>
        <td>
          <router-link
            v-bind:to="{ name: 'product-detail', params: { id: product.id }}"
          >{{ product.name }}</router-link>
        </td>
        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "products-list"
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
