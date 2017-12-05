package controleur;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Proprietaire;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private Gson gson = new Gson();
    private static String baseURL = "http://localhost:8080/mediatheque/";

    @RequestMapping("")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/adherents")
    public String getAdherents(Model model) {
        try {
            URL url = new URL(baseURL + "Adherents");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            List<String> lines = br.lines().collect(Collectors.toList());
            TypeToken listType = new TypeToken<ArrayList<Adherent>>(){};
            List<Adherent> adherents = gson.fromJson(lines.get(0), listType.getType());
            model.addAttribute("adherents", adherents);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adherents";
    }

    @RequestMapping("/adherents/ajouter")
    public String addAdherent(Model model) {
        Adherent adherent = new Adherent();
        model.addAttribute("adherent", adherent);
        return "formAdherent";
    }

    @RequestMapping("/adherents/modifier/{id}")
    public String alterAdherent(Model model, @PathVariable("id") int id) {
        List<Adherent> adherents = new ArrayList<>();
        try {
            URL url = new URL(baseURL + "Adherents");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            List<String> lines = br.lines().collect(Collectors.toList());
            TypeToken listType = new TypeToken<ArrayList<Adherent>>(){};
            adherents = gson.fromJson(lines.get(0), listType.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Adherent adherent = adherents.stream().filter(a -> a.getIdAdherent() == id).findFirst().get();
        model.addAttribute("adherent", adherent);

        return "formAdherent";
    }

    @RequestMapping("/adherents/insertion")
    public String insertAdherent(Model model, @ModelAttribute("adherent") @Validated Adherent adherent) {
        String url = baseURL + "adherents/insertion";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity data = null;
        try {
            data = new StringEntity(gson.toJson(adherent));
        } catch (Exception e) {
            e.printStackTrace();
        }
        post.setEntity(data);
        post.setHeader("Content-Type", "application/json");
        HttpResponse response = null;
        try {
            response = httpClient.execute(post);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean flag = (response != null && response.getStatusLine().getStatusCode() == 200);
        model.addAttribute("success", flag);

        return "redirect:/adherents";
    }

    @RequestMapping("/adherents/supprimer/{id}")
    public String deleteAdherents(Model model, @PathVariable("id") int id) {
        String url = baseURL + "adherents/suppression/" + id;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpDelete delete = new HttpDelete(url);
        HttpResponse response = null;
        try {
            response = httpClient.execute(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean flag = (response != null && response.getStatusLine().getStatusCode() == 200);

        model.addAttribute("success", flag);

        return "redirect:/adherents";
    }

    @RequestMapping("/oeuvres")
    public String getOeuvres(Model model) {
        try {
            URL url = new URL(baseURL + "Oeuvres");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            List<String> lines = br.lines().collect(Collectors.toList());
            TypeToken listType = new TypeToken<ArrayList<Oeuvrevente>>(){};
            List<Oeuvrevente> oeuvreventes = gson.fromJson(lines.get(0), listType.getType());
            model.addAttribute("oeuvres", oeuvreventes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "oeuvres";
    }

    @RequestMapping("/oeuvres/ajouter")
    public String addOeuvre(Model model) {
        try {
            URL url = new URL(baseURL + "Proprietaires");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            List<String> lines = br.lines().collect(Collectors.toList());
            TypeToken listType = new TypeToken<ArrayList<Proprietaire>>(){};
            List<Proprietaire> proprietaires = gson.fromJson(lines.get(0), listType.getType());
            model.addAttribute("proprietaires", proprietaires);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Oeuvrevente oeuvrevente = new Oeuvrevente();
        model.addAttribute("oeuvrevente", oeuvrevente);
        return "formOeuvre";
    }

    @RequestMapping("/oeuvres/modifier/{id}")
    public String alterOeuvre(Model model, @PathVariable("id") int id) {
        List<Oeuvrevente> oeuvreventes = new ArrayList<>();
        try {
            URL url = new URL(baseURL + "Oeuvres");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            List<String> lines = br.lines().collect(Collectors.toList());
            TypeToken listType = new TypeToken<ArrayList<Oeuvrevente>>(){};
            oeuvreventes = gson.fromJson(lines.get(0), listType.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL(baseURL + "Proprietaires");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            List<String> lines = br.lines().collect(Collectors.toList());
            TypeToken listType = new TypeToken<ArrayList<Proprietaire>>(){};
            List<Proprietaire> proprietaires = gson.fromJson(lines.get(0), listType.getType());
            model.addAttribute("proprietaires", proprietaires);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Oeuvrevente oeuvrevente = oeuvreventes.stream().filter(a -> a.getIdOeuvrevente() == id).findFirst().get();
        model.addAttribute("oeuvrevente", oeuvrevente);
        return "formOeuvre";
    }

    @RequestMapping(value = "/oeuvres/insertion", method = RequestMethod.POST)
    public String insertOeuvre(Model model,
                               @RequestParam("titreOeuvrevente") String titreOeuvrevente,
                               @RequestParam("etatOeuvrevente") String etatOeuvrevente,
                               @RequestParam("prixOeuvrevente") float prixOeuvrevente,
                               @RequestParam("proprietaire") Integer idProprietaire,
                               @RequestParam(name="idOeuvrevente",required=false) Integer idOeuvrevente) {
        Oeuvrevente oeuvrevente = new Oeuvrevente();
        oeuvrevente.setTitreOeuvrevente(titreOeuvrevente);
        oeuvrevente.setEtatOeuvrevente(etatOeuvrevente.toUpperCase());
        oeuvrevente.setPrixOeuvrevente(prixOeuvrevente);

        if(idOeuvrevente==null)
            idOeuvrevente = 0;

        oeuvrevente.setIdOeuvrevente(idOeuvrevente);

        Proprietaire proprietaire = new Proprietaire();
        proprietaire.setIdProprietaire(idProprietaire);
        oeuvrevente.setProprietaire(proprietaire);
        String url = baseURL + "oeuvres/insertion";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity data = null;
        try {
            data = new StringEntity(gson.toJson(oeuvrevente));
        } catch (Exception e) {
            e.printStackTrace();
        }
        post.setEntity(data);
        post.setHeader("Content-Type", "application/json");
        HttpResponse response = null;
        try {
            response = httpClient.execute(post);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean flag = (response != null && response.getStatusLine().getStatusCode() == 200);
        model.addAttribute("success", flag);

        return "redirect:/oeuvres";
    }


    @RequestMapping("/oeuvres/supprimer/{id}")
    public String deleteOeuvre(Model model, @PathVariable("id") int id) {
        String url = baseURL + "oeuvres/suppression/" + id;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpDelete delete = new HttpDelete(url);
        HttpResponse response = null;
        try {
            response = httpClient.execute(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean flag = (response != null && response.getStatusLine().getStatusCode() == 200);

        model.addAttribute("success", flag);
        return "redirect:/oeuvres";
    }
}
