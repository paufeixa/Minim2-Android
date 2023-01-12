Android del Mínimo 2

Se ha añadido en el Navigation Menu una opción para ir a las FAQs. Se ha puesto donde antes estaba la parte social, ya que aún no estaba en uso.
Para hacerlo, se ha añadido un xml para este nuevo Fragment (no es exactamente una nueva actividad).
Se ha modificado el bottom_navmenu.xml (carpeta menu), así como se ha añadido la foto faqs.png en la carpeta drawable para tener un icono adecuado.
Ha sido necesario hacer otro Adapter para poder introducir los datos correspondientes.
Evidentemente, ha sido necesario modificar la interfaz Api, para añadir otra nueva ruta para comunicarse con el servidor (getFaqs).
Al usar el Navigation Menu, la clase MainPrincipal ha sido modificada para poder ir al fragmento FaqsFragment (donde se hace el get para las FAQs) al tocar en la parte de FAQs del menú.
Todo funciona correctamente, ya que al entrar en las FAQs, se cargan todas ellas en un RecyclerView, por lo que puede haber muchas preguntas y respuestas sin problema.
