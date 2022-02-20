<?php

namespace App\Entity;

use App\Repository\ExerciceRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=ExerciceRepository::class)
 */
class Exercice
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $code_exercice;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $Mouvement;

    /**
     * @ORM\Column(type="text")
     */
    private $desc_exercice;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getCodeExercice(): ?string
    {
        return $this->code_exercice;
    }

    public function setCodeExercice(string $code_exercice): self
    {
        $this->code_exercice = $code_exercice;

        return $this;
    }

    public function getMouvement(): ?string
    {
        return $this->Mouvement;
    }

    public function setMouvement(string $Mouvement): self
    {
        $this->Mouvement = $Mouvement;

        return $this;
    }

    public function getDescExercice(): ?string
    {
        return $this->desc_exercice;
    }

    public function setDescExercice(string $desc_exercice): self
    {
        $this->desc_exercice = $desc_exercice;

        return $this;
    }
}
